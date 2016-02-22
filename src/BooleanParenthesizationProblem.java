/*
    Reference: http://www.geeksforgeeks.org/dynamic-programming-set-37-boolean-parenthesization-problem/

    Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
    Let the input be in form of two arrays one contains the symbols (T and F) in order and other contains operators (&, | and ^}
 */

/*
    Input: symbol[]    = {T, F, T}
           operator[]  = {^, &}
    Output: 2
    The given expression is "T ^ F & T", it evaluates true
    in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

    Input: symbol[]    = {T, F, F}
           operator[]  = {^, |}
    Output: 2
    The given expression is "T ^ F | F", it evaluates true
    in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )".

    Input: symbol[]    = {T, T, F, T}
           operator[]  = {|, &, ^}
    Output: 4
    The given expression is "T | T & F ^ T", it evaluates true
    in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T)
    and (T|((T&F)^T)).
 */

public class BooleanParenthesizationProblem {
    public static int countCombination(char[] operator, char[] sym){
        int n = sym.length;
        int[][] T = new int[n][n];
        int[][] F = new int[n][n];
        for(int i = 0; i < n; i++){
            T[i][i] = sym[i] == 'T'?1:0;
            F[i][i] = sym[i] == 'F'?1:0;

        }
        for(int gap = 1; gap < n; gap++){
            for(int i = 0,  j = gap; j < n; i++,j++){
                T[i][j] = F[i][j] = 0;
                for(int g = 0; g < gap; g++){
                    int k = i+g;
                    if(operator[k] == '&'){
                        T[i][j] += T[i][k]*T[k+1][j];
                        F[i][j] += F[i][k]*F[k+1][j] + F[i][k]*T[k+1][j]+ T[i][k]*F[k+1][j];
                    }
                    if(operator[k] == '|'){
                        T[i][j] += T[i][k]*T[k+1][j]+F[i][k]*T[k+1][j]+ T[i][k]*F[k+1][j];
                        F[i][j] += F[i][k]*F[k+1][j];

                    }
                    if(operator[k] == '^'){
                        T[i][j] += F[i][k]*T[k+1][j]+ T[i][k]*F[k+1][j];
                        F[i][j] += T[i][k]*T[k+1][j]+ F[i][k]*F[k+1][j];

                    }


                }
            }
        }
        return T[0][n-1];
    }

    public static void main(String[] args) {
        char[] sym = {'T', 'T', 'F', 'T'};
        char[] operator = {'|', '&', '^'};
        System.out.print(countCombination(operator,sym));
    }
}

