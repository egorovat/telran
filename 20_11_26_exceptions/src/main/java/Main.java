

public class Main {

    static boolean toThrow = false;

    public static void main(String args[]) {
        Echo e1 = new Echo();
        Echo e2 = e1;

        int x = 0;
        while (x < 4){
            e1.hello();
            e1.count = e1.count + 1;
            if(x == 3){
                e2.count = e2.count + 1;

            }
            if(x > 0){
                e2.count = e2.count + e1.count;
            }
            x = x + 1;
        }
        System.out.println(e2.count);
    }
}

/*        methodA();

        toThrow = true;

        try {
            System.out.println("Before method call");
            methodA();
            System.out.println("After method call");

        }catch (AUncheckedException e){
            System.out.println("Under the first A catch");
        }
        catch (Exception e) {

            System.out.println("Under the Exception catch");
        }


        try {
            methodB();
        } catch (BUncheckedException e) {
           // e.printStackTrace();
            System.out.println("Under B checked catch");
        }

        finally {
            System.out.println("Under finally");
        }

        try{
            methodC();
        }catch (IndexOutOfBoundsException e){
            System.out.println("method C with IndexOutOfBoundsException");
        }

        try{
            methodD();
        }catch (NullPointerException e){
            System.out.println("method D catch");
        }

    }

    static void methodA(){

        if(toThrow) throw new  AUncheckedException();
    }

    /**
     * @throws BUncheckedException
     */
  /*  static void methodB() throws BUncheckedException {

        if(toThrow) throw new BUncheckedException();
    }

    static void methodC(){
        try{
            methodA();

        } catch (AUncheckedException e){

        }
        finally {
            throw new IndexOutOfBoundsException();
        }

    }

    static void methodD(){

        try{
            methodA();

        } catch (AUncheckedException e){
            throw new IndexOutOfBoundsException();
        }
        finally {
            throw new NullPointerException();
        }
    }
}
*/