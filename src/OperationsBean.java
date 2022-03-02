public class OperationsBean {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    private String username;
   private String operator;
   private int operand1;
        private int operand2;
        private double result;

    @Override
    public String toString() {
        return "{" +
                username + '|' +
                operator + '|' +
                 operand1 + '|' +
               operand2 + '|' +
               result + '|' + '}';
    }
}
