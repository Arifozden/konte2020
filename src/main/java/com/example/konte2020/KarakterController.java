package com.example.konte2020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KarakterController {
    @Autowired
    private JdbcTemplate db;
    private Logger logger = LoggerFactory.getLogger(KarakterController.class);
    @PostMapping("/lagre")
    public String lagreMelding(Karakter k) {
        String sid = "[0-9]{6}";
        String fid= "[A-Z]{4}[0-9]{4}";
        if(k.getSid().matches(sid) && k.getFid().matches(fid)){
// sjekk om studenten og faget finnes
            String sql1 = "Select Count(*) from student where sid = ?";
            String sql2 = "Select Count(*) from fag where fid = ?";
            int enStudent = db.queryForObject(sql1,Integer.class,k.getSid());
            int etfag = db.queryForObject(sql2,Integer.class,k.getFid());
            if(enStudent > 0 && etfag > 0){
                try{
                    String sql = "INSERT INTO StudentFag (Sid,Fid,Aar,Karakter,Prosent) VALUES(?,?,?,?,?)";
                    db.update(sql,k.getSid(),k.getFid(),k.getAar(),k.getKarakter(),k.getProsent());
                    return "Registrering er foretatt";
                }
                catch (Exception e){
                    logger.error("Feil i insert for student/fag "+e);
                    return "Feil ved registrering i database";
                }
            }
            else
                return "Fant enten ikke studenten eller faget!";
        }
        return "Feil i inputvalidering på server!";
    }

    @GetMapping("/hentKarakterer")
    public List<Karakter> heltAlleKarakterer() {
        String sql = "Select * from StudentFag";
        List<Karakter> alleKarakterer = db.query(sql, new BeanPropertyRowMapper(Karakter.class));
        return alleKarakterer;
    }
}
