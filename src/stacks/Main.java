/**
 * Name: Zachary Harel
 * Project: Stack Evaluation Lab
 * Date: 12/9/24
 * Main class for the stack lab.
 */

package stacks;

public class Main {
    public static void main(String[] args) {
        Evaluator evaluator1 = new Evaluator("((1+2)*(3+4))");
        Evaluator evaluator2 = new Evaluator("(((13 - 1) / 2) * (3 + 5))");
        System.out.println(evaluator1.getExpression() + " = " + evaluator1.evaluate());
        System.out.println(evaluator2.getExpression() + " = " + evaluator2.evaluate());
    }
}

/* OUTPUT:
((1+2)*(3+4)) = 21
(((13 - 1) / 2) * (3 + 5)) = 48
*/