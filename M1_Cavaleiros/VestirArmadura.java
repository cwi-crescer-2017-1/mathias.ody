public class VestirArmadura implements Movimento {
   private Saint saint;
   public VestirArmadura (Saint saint) {
       this.saint = saint;
   }
   
   public void setup (Saint saint1, Saint saint2) {}
   
   public void executar() {
       this.saint.vestirArmadura();
   }
   
   public String text () { return "";}
}
