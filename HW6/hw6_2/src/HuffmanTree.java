import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;

public class HuffmanTree implements Serializable {

  private HashMap<Character, String> mydata= new HashMap<Character, String>();

  // Nested Classes
  /** A datum in the Huffman tree. */
  public static class HuffData
      implements Serializable {
    // Data Fields
    /** The weight or probability assigned to this HuffData. */
    private double weight;

    /** The alphabet symbol if this is a leaf. */
    private Character symbol;

    public HuffData(double weight, Character symbol) {
      this.weight = weight;
      this.symbol = symbol;
    }
  }

  // Data Fields
  /** A reference to the completed Huffman tree. */
  public BinaryTree < HuffData > huffTree;

  /** A Comparator for Huffman trees; nested class. */
  private static class CompareHuffmanTrees
      implements Comparator< BinaryTree < HuffData >> {
    /** Compare two objects.
        @param treeLeft The left-hand object
        @param treeRight The right-hand object
        @return -1 if left less than right,
                0 if left equals right,
                and +1 if left greater than right
     */
    public int compare(BinaryTree < HuffData > treeLeft,
                       BinaryTree < HuffData > treeRight) {
      double wLeft = treeLeft.getData().weight;
      double wRight = treeRight.getData().weight;
      return Double.compare(wLeft, wRight);
    }
  }

  /** Builds the Huffman tree using the given alphabet and weights.
      post:  huffTree contains a reference to the Huffman tree.
      @param symbols An array of HuffData objects
   */
  public void buildTree(HuffData[] symbols) {
    Queue< BinaryTree < HuffData >> theQueue
        = new PriorityQueue< BinaryTree < HuffData >>
        (symbols.length, new CompareHuffmanTrees());
    // Load the queue with the leaves.
    for (HuffData nextSymbol : symbols) {
      BinaryTree < HuffData > aBinaryTree =
          new BinaryTree < HuffData > (nextSymbol, null, null);
      theQueue.offer(aBinaryTree);
    }

    // Build the tree.
    while (theQueue.size() > 1) {
      BinaryTree < HuffData > left = theQueue.poll();
      BinaryTree < HuffData > right = theQueue.poll();
      double wl = left.getData().weight;
      double wr = right.getData().weight;
      HuffData sum = new HuffData(wl + wr, null);
      BinaryTree < HuffData > newTree =
          new BinaryTree < HuffData > (sum, left, right);
      theQueue.offer(newTree);
    }

    // The queue should now contain only one item.
    huffTree = theQueue.poll();
  }

  /** Outputs the resulting code.
      @param out A PrintStream to write the output to
      @param code The code up to this node
      @param tree The current node in the tree
   */
  public void printCode(PrintStream out, String code,
                         BinaryTree < HuffData > tree) {
    HuffData theData = tree.getData();
    if (theData.symbol != null) {
      if (theData.symbol.equals(" ")) {
        out.println("space: " + code);
      }
      else {
        out.println(theData.symbol + ": " + code);
      }
    }
    else {
      printCode(out, code + "0", tree.getLeftSubtree());
      printCode(out, code + "1", tree.getRightSubtree());
    }
  }

public String encode(String symbol){

    String result="";
    helper(System.out,"",huffTree,symbol);

    if(symbol.length()==1) {
      if (mydata.containsKey(symbol.charAt(0))) {

        result = symbol + " -->" + mydata.get(symbol.charAt(0));
      }

    }
    else{

      for(int i=0; i<symbol.length(); i++) {

        if(mydata.containsKey(symbol.charAt(i))){

          if(i==0){

          }
          result+= mydata.get(symbol.charAt(i)) + "" ;
        }
        else{
          System.out.println("'"+symbol.charAt(i)+"'"+" : Ağaçta böyle bir sembol bulunmamaktadır.");
          System.exit(0);
        }
      }
    }

    return result;
  }

private void helper(PrintStream out, String code, BinaryTree < HuffData > tree,String s){


  HuffData theData = tree.getData();
  if (theData.symbol != null) {

    if (theData.symbol.equals(" ")) {
      //out.println("space: " + code);
    }
    else {
      mydata.put(theData.symbol,code);
    }
  }
  else {
    helper(out, code + "0", tree.getLeftSubtree(),s);
    helper(out, code + "1", tree.getRightSubtree(),s);
  }

}

  public String decode(String codedMessage) {
    StringBuilder result = new StringBuilder();
    BinaryTree < HuffData > currentTree = huffTree;
    for (int i = 0; i < codedMessage.length(); i++) {
      if (codedMessage.charAt(i) == '1') {
        currentTree = currentTree.getRightSubtree();
      }
      else {
        currentTree = currentTree.getLeftSubtree();
      }
      if (currentTree.isLeaf()) {
        HuffData theData = currentTree.getData();
        result.append(theData.symbol);
        currentTree = huffTree;
      }
    }
    return result.toString();
  }

}
