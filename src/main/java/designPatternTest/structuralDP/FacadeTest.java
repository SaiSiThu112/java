package designPatternTest.structuralDP;

interface Utility{
    void throwUtility();
}

class Smoke implements Utility{

    @Override
    public void throwUtility() {
        System.out.println("throw smoke");
    }
}
class Grande implements Utility{

    @Override
    public void throwUtility() {
        System.out.println("throw grande");
    }
}
class Flash implements Utility{

    @Override
    public void throwUtility() {
        System.out.println("throw flash");
    }
}

class Site {
    Smoke smoke = new Smoke();
    Grande grande = new Grande();
    Flash flash = new Flash();

      public void rush(){
          smoke.throwUtility();
          flash.throwUtility();
          grande.throwUtility();
      }
}
class FacadeDP {
    public static void main(String[] args) {
        Site facade = new Site();
        facade.rush();
    }
}
