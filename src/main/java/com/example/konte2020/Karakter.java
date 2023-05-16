package com.example.konte2020;

public class Karakter {
    private String sid;
    private String fid;
    private String navn;
    private String aar;
    private String karakter;
    private String prosent;
    public Karakter(String sid, String fid, String navn, String aar, String karakter, String prosent) {
        this.sid = sid;
        this.fid = fid;
        this.navn = navn;
        this.aar = aar;
        this.karakter = karakter;
        this.prosent = prosent;
    }
    public Karakter() {
    }
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getFid() {
        return fid;
    }
    public void setFid(String fid) {
        this.fid = fid;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public String getAar() {
        return aar;
    }
    public void setAar(String aar) {
        this.aar = aar;
    }
    public String getKarakter() {
        return karakter;
    }
    public void setKarakter(String karakter) {
        this.karakter = karakter;
    }
    public String getProsent() {
        return prosent;
    }
    public void setProsent(String prosent) {
        this.prosent = prosent;
    }
}
