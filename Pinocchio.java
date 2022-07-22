package oop.pinocchio_exercise;

public class Pinocchio {

    private final static int newNose = 1;
    private int noseSize = 1;
    private int goodDeedCounter = 0;
    private boolean hasHead = true;

    private boolean canBecomeReal = true;

    private boolean isARealBoy = false;

    public void becomeRealBoy() {
        if (isARealBoy == true) {
            noseSize = newNose;
        }
        return;
    }

    public void doGoodDeeds() {
        if (isARealBoy == true) {
            System.out.println("Such a good boy!!!");
            return;
        }
        if (checkHeadStatus() == true) {
            if (headExplode() == true) {
                goodDeedCounter++;
                noseSize--;
                System.out.println("Pinocchio's nose shrunk. He did a good deed.");
                if (goodDeedCounter >= 3 && noseSize <= -2 && canBecomeReal == true) {
                    isARealBoy = true;
                    becomeRealBoy();
                    System.out.println("Pinocchio became a real boy and has a new nose!");
                    return;
                }
            }
        }
        return;
    }

    public void repairHead() {
        if (hasHead == false) {
            hasHead = true;
            noseSize = 1;
            System.out.println("Pinocchio's head was repaired.");
            return;
        }
        if (hasHead) {
            System.out.println("Can't repair attached head.");
            return;
        }
    }

    public boolean headExplode() {
        if (this.noseSize >= 5) {
            System.out.println("Pinocchio's head exploded... He can't become a real boy now..");
            canBecomeReal = false;
            return hasHead = false;
        }
        return true;
    }

    public boolean checkHeadStatus() {
        if (!hasHead) {
        }
        return true;
    }

    public void tellLies() {
        goodDeedCounter = 0;
        if (isARealBoy == true) {
            System.out.println("Lie at will!");
            return;
        }
        if (checkHeadStatus() == true) {
            if (headExplode() == true) {
                this.noseSize++;
                System.out.println("Pinocchio's nose grew.");
            }
        }
        return;
    }
}