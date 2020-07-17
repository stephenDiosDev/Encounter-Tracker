public class Actor {

    private String name;
    private int initiative, currentHp, maxHp;

    public Actor() {
        this.name = "PLACEHOLDER";
        this.initiative = -1;
        this.currentHp = -1;        //-1 hp for both vars means not tracking hp
        this.maxHp = -1;
    }

    public Actor(String name, int initiative, int hp) {
        this.setName(name);
        this.setInitiative(initiative);
        this.setMaxHp(hp);
        this.setCurrentHp(hp);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setCurrentHp(int currentHp) {
        if(currentHp > this.getMaxHp()) {   //if incoming currentHp exceeds max, just set to max
            this.currentHp = this.getMaxHp();
        }
        else {
            this.currentHp = currentHp;
        }
    }

    public void setMaxHp(int maxHp) {
        if(maxHp >= -1) {
            this.maxHp = maxHp;
        }
        else {
            System.err.println("Cannot create an actor with hp lower than -1!");
            System.exit(0);
        }
    }

    /**
     * Adds the incoming amount to the currentHp. CurrentHp is bound between 0 and maxHp (inclusive)
     * @param amount The amount to add/subtract from the currentHp
     */
    public void modifyHp(int amount) {
        //do a check to make sure it doesn't exceed maxHp or go negative
        if((this.getCurrentHp() + amount) < 0) {
            this.setCurrentHp(0);
        }
        else if ((this.getCurrentHp() + amount) > this.getMaxHp()) {
            this.setCurrentHp(this.getMaxHp());
        }
        else {  //amount will be between the allowable range
            this.setCurrentHp(this.getCurrentHp() + amount);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getInitiative() {
        return this.initiative;
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " Initiative: " + this.getInitiative() + " Max HP: " + this.getMaxHp() +
                " Current HP: " + this.getCurrentHp() + "\n";
    }

    //tests only
    public static void main (String[] args) {
        /*
        TODO
        [X]Test default constructor
        [X]Test custom constructor with good values
        [X]Test custom constructor for 2 cases of health values
        [X]Test all 3 cases of modifyHp
         */

        Actor a1 = new Actor();
        Actor a2 = new Actor("sbeve", 5, 100);
        Actor a3 = new Actor("brenda", 1, 10);
        Actor a5 = new Actor("harold", 0, 20);

        System.out.println("\nTesting constructors\n");
        System.out.print(a1.toString());
        System.out.print(a2.toString());
        System.out.print(a3.toString());
        System.out.print(a5.toString());

        System.out.println("\nTesting modifyHp method\n");
        a2.modifyHp(-100);
        a3.modifyHp(-4);
        a1.modifyHp(10);

        System.out.print(a1.toString());
        System.out.print(a2.toString());
        System.out.print(a3.toString());
    }
}