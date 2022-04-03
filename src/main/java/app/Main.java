package app;

public class Main {
    public static void main(String[] args) {
        if (args.length>0){

            Form myapp = new Form(args[0]);
        } else {
            Form myapp = new Form("SsNNNNNN");
        }

        //Form myapp = new Form();
        //System.out.println(new PasswordGenerator("AB",4).getPass());
    }
}




