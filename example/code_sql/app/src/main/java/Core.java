public class Core {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No args found, exiting program ...");
            System.exit(1);
        } else if (!args[0].equalsIgnoreCase("solve") && !args[0].equalsIgnoreCase("run")) {
            System.err.println(args[0] + " is not a supported argument");
            System.exit(1);
        }
        DBComparator dbComparator = new DBComparator(args[0].equalsIgnoreCase("solve"));
        dbComparator.compare();
    }
}