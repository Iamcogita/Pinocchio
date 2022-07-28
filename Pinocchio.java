package oop.pinocchio_exercise;

public class Pinocchio {

    private final static int newNose = 1;
    private int noseSize = 1;
    private int goodDeedCounter = 0;
    private boolean hasHead = true;

    private boolean canBecomeReal = true;

    private boolean isARealBoy = false;

    public void tryToBecomeReal(int beGood, int tellLies) {
        boolean firstTime = true;
        int numOfActions = beGood + tellLies;
        for (int i = 1; i <= numOfActions; i++) {
            if (tellLies < 0 || beGood < 0 && firstTime) {
                firstTime = false;
                System.out.println("Try to keep it positive.");
                return;
            }
            if (!hasHead) repairHead();
            if (beGood == tellLies) {
                System.out.println("Pinocchio's nose is the same.");
                return;
            }
            if (tellLies - beGood > 0) tellLies();
            if (beGood - tellLies > 5) doGoodDeeds();
            if (beGood - tellLies > 2) doGoodDeeds();
            if (beGood - tellLies > 1) doGoodDeeds();
            if (tellLies > 0) tellLies();
            if (beGood > 0) doGoodDeeds();
            if (i == numOfActions) {
                System.out.println("Start over?");
            }
        }
    }

    public void becomeRealBoy() {
        if (isARealBoy == true) {
            noseSize = newNose;
        }
    }

    public void doGoodDeeds() {
        if (isARealBoy == true) {
            System.out.println("Such a good boy!!!");
            return;
        }
        if (headExplode() == false) {
            goodDeedCounter++;
            noseSize--;
            System.out.println("Pinocchio's nose shrunk. He did a good deed.");
            if (goodDeedCounter >= 3 && noseSize <= -2 && canBecomeReal == true) {
                isARealBoy = true;
                becomeRealBoy();
                System.out.println("Pinocchio became a real boy and has a new nose!");
            }
        }
    }

    public void repairHead() {
        if (!hasHead) {
            hasHead = true;
            noseSize = 1;
            System.out.println("Pinocchio's head was repaired.");
            return;
        }
        if (hasHead) {
            System.out.println("Can't repair attached head.");
        }
    }

    public boolean headExplode() {
        if (this.noseSize >= 5) {
            System.out.println("Pinocchio's head exploded... He can't become a real boy now..");
            canBecomeReal = false;
            hasHead = false;
            return true;
        }
        return false;
    }

    public void tellLies() {
        goodDeedCounter = 0;
        if (isARealBoy == true) {
            System.out.println("Lie at will!");
            return;
        }
        if (headExplode() == false) {
            this.noseSize++;
            System.out.println("Pinocchio's nose grew.");
        }
    }
}