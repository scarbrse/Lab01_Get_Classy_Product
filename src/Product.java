public class Product {

    /**
     * Variables
     */

    private String ID;
    private String pName;
    private String pDescription;
    private double pPrice;

    static private double IDSeed = 1;



    public static void setIDSeed(double IDSeed) { Product.IDSeed = IDSeed; }

    public static double getIDSeed() {return IDSeed; }



    /**
     * Product Constructor
     */
    public Product(String ID, String pName, String pDescription, double pPrice) {
        this.ID = ID;
        this.pName = pName;
        this.pDescription = pDescription;
        this.pPrice = pPrice;
    }


    /**
     *
     * Product setters and getters
     */
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }


    /**
     * Takes ID, pName, pDescription, and cost that converts the String to CSV Format.
     */

    public String toCSV(){
        return this.ID + ", " + this.pName + ", " + this.pDescription + ", " + this.pPrice;
    }
}