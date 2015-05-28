package matrixes;

class MultiplyThread implements Runnable
{
    
    private int startColumn;
    private int endColumn;
    private MatrixMultiplication multiplication = new MatrixMultiplication();


  public MultiplyThread(MatrixMultiplication multiplication, int startColumn, int endColumn) {
      this.startColumn = startColumn;
      this.endColumn = endColumn;
      this.multiplication= multiplication;
  }

@Override
public void run() {
    multiplication.multiplyFromTo(startColumn, endColumn);
}
}
