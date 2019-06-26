#include <bits/stdc++.h>
using namespace std;

int precedence(char ch){
    if( ch ='^')
        return 3;
    else if( ch == '*' || ch=='/')
        return 2;
    else if( ch == '+' || ch=='-')
        return 1;
    else return -1;
}
void infix_to_postfix(string s){
    std::stack<char> st;
    st.push('N');
    int l = s.length();
    string newstring;
    for(int i=0;i<l;i++)
    {
        if((s[i] >='a' && s[i] <='z') || (s[i] >='A' && s[i] <= 'Z'))  newstring = s[i];
        
        else if( s[i] == '('  )
            st.push('(');
        else if( s[i] == ')'  ){
            while(st.top()!= 'N' && st.top()!= '(' )
            {
                char c = st.top();
                st.pop();
                newstring += c;
            }
            if(st.top()== '(')
            {
                char c = st.top();
                st.pop();
            }
        } 
        else {
            while(st.top() != 'N' && precedence(s[i]) <= precedence(st.top())){
                char c = st.top();
                st.pop();
                newstring += c;
            }
            st.push(s[i]);
        }
    }
    
     while(st.top() != 'N') 
    { 
        char c = st.top(); 
        st.pop(); 
        newstring += c; 
    } 
      
    cout << newstring << endl; 
    
    
}

int main() {
    std::cout << "Infix to postfix\n";
    string exp = "a+b*(c^d-e)^(f+g*h)-i";
    infix_to_postfix(exp);
    return 0;
}
"""
output:
abcd^e-fgh*+^*+i-
"""
