public class ProgramBoilerPlater {
    public static void main(String [] args) {
        if (args.length == 0) {
            System.out.println("Please spcify and input file.");
            return;
        }
        
        String filename = args[0];
        File inputFile = null;
        Scanner scan = null;
        
        try {
            inputFile = new File(filename);
            scan = new Scanner(inputFile);   
        } catch (Exception e) {
            System.out.println("An error occured");
            return;
        }

        int testCases = scan.nextInt();

        for(int i  = 0; i < testCases; i++) {
            // add program logic here
        }
    }
}