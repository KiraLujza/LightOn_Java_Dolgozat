
package modell;


public class LightOnModell {
    
    private int gombSzam;
    private boolean szin;
    
    public LightOnModell(int gombSzam, boolean szin){
        
        this.gombSzam = gombSzam;
        this.szin = szin;
        
    }
    
    public LightOnModell(){
        
    }
    
    private int getGombSzam(){
        return this.gombSzam;
    }
    
    private boolean getSzin(){
        
        return this.szin;
    }
    
    private void setGombSzam(int ujGombSzam){
        this.gombSzam = ujGombSzam;
        
    }
    
    private void setSzin(boolean ujSzin){
        this.szin = ujSzin;
    }
    
}
