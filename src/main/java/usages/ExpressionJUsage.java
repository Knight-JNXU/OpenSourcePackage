package usages;

import org.da.expressionj.expr.parser.EquationParser;

import java.util.Scanner;

/**
 * @author knight
 * @createtime : 2017/04/10 20:59
 * @description : 探究ExpressionJ开源包的用法
 * @result :
 */

public class ExpressionJUsage {

    /**
     * 基本用法
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String inputStr = null;
        while (!"#".equals(inputStr)){
            inputStr = scanner.nextLine();
            System.out.println(EquationParser.parse(inputStr).eval());
        }

    }

}
