function validerSid(){
    const sId = $("#sId").val();
    const regexp = /^[0-9]{6}$/;
    const ok = regexp.test(sId);
    if(!ok){
        $("#feilSid").html("Studentnummeret må være 6 siffer");
        return false;
    }
    else{
        $("#feilSid").html("");
        return true;
    }
}
function validerFid(){
    const fId = $("#fId").val();
    const regexp = /^[A-Z]{4}[0-9]{4}$/;
    const ok = regexp.test(fId);
    if(!ok){
        $("#feilFid").html("Fagnavnet må være 4 store bokstaver og 4 siffer");
        return false;
    }
    else{
        $("#feilFid").html("");
        return true;
    }
}
function regKarakter() {
    const karakter = {
        sid : $("#sId").val(),
        fid : $("#fId").val(),
        aar : $("#aar").val(),
        karakter : $("#karakter").val(),
        prosent : $("#prosent").val()
    };
    if(validerFid() && validerSid()){
        $.post("/lagre", karakter, function(feilmeldinger){
            $("#feilRegistrering").html(feilmeldinger);
            heltAlle();
        });
    }
}

function heltAlle(){
    $.get("/hentKarakterer", function(karakterene){
// format karakterer
        let sum=0;
        let antall = 0;
        let ut="<table>" +
            "<tr><th>Fag</th><th>Studentnr</th><th>Karakter</th></tr>";
        for(let k of karakterene){
            ut+="<tr><td>"+k.fid+"</td><td>"+k.sid+"</td><td>"+k.karakter+"</td></tr>";
            sum+=k.prosent;
            antall++;
        };
        ut+="</table>";
        const gjennomsnitt = sum/antall;
        ut+="<br><br>Gejennomsnittet er "+gjennomsnitt+" % ";
        $("#resultater").html(ut);
    });
}