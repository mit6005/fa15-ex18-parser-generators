package sums;

/** Immutable type representing a sum of integers. */
public interface Sum {
    // Data type definition
    //    Sum = Number(n:int) + Plus(left:Sum, right:Sum)
        
    /** @return the computed value of this sum */
    public int value();
}

class Number implements Sum {
    private final int n;
    
    // Abstraction function
    //    represents the integer n
    // Rep invariant
    //    true
    // Safety from rep exposure
    //    all fields are immutable and final
    
    /** Make a Number. */
    public Number(int n) {
        this.n = n;
    }
    
    @Override public int value() {
        return n;
    }
    
    @Override public String toString() {
        return String.valueOf(n);
    }
}

class Plus implements Sum {
    private final Sum left, right;
    
    // Abstraction function
    //    represents the sum of two expressions left+right
    // Rep invariant
    //    true
    // Safety from rep exposure
    //    all fields are immutable and final
    
    /** Make a Plus which is the sum of left and right. */
    public Plus(Sum left, Sum right) {
        this.left = left;
        this.right = right;
    }
    
    @Override public int value() {
        return left.value() + right.value();
    }
    
    @Override public String toString() {
        return "("+left+")+("+right+")";
    }
}

