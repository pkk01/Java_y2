abstract class LeaveApprover {
    protected LeaveApprover nextApprover;

    public void setNextApprover(LeaveApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void approveLeave(int numberOfDays) {        
        if (canApprove(numberOfDays)) {
            approve(numberOfDays);
        } else if (nextApprover != null) {
            nextApprover.approveLeave(numberOfDays);
        } else {
            System.out.println("Leave request for " + numberOfDays + " cannot be Approved");
        }
    }

    abstract protected boolean canApprove(int numberOfDays);

    abstract protected void approve(int numberOfDays);
}

class HoD extends LeaveApprover {
    private static final int Max_Days = 2;

    protected boolean canApprove(int numberOfDays) {
        return numberOfDays <= Max_Days;
    }

    protected void approve(int numberOfDays) {
        System.out.println("HoD Approved " + numberOfDays + " days Leave");
    }
}

class Principal extends LeaveApprover {
    private static final int Max_Days = 5;

    protected boolean canApprove(int numberOfDays) {
        return numberOfDays <= Max_Days;
    }

    protected void approve(int numberOfDays) {
        System.out.println("Principal Approved " + numberOfDays + " days Leave");
    }
}

class Registrar extends LeaveApprover {
    private static final int Max_Days = 10;

    protected boolean canApprove(int numberOfDays) {
        return numberOfDays <= Max_Days;
    }

    protected void approve(int numberOfDays) {
        System.out.println("Registrar Approved " + numberOfDays + " days Leave");
    }
}

class LeaveApprovelChain {
    public static LeaveApprover createChain() {
        LeaveApprover hd = new HoD();
        LeaveApprover pr = new Principal();
        LeaveApprover re = new Registrar();
        hd.setNextApprover(pr);
        pr.setNextApprover(re);
        return hd;

    }
}

public class ChainofMain {
    public static void main(String[] args) {
        LeaveApprover la = LeaveApprovelChain.createChain();
        la.approveLeave(11);
    }
}
