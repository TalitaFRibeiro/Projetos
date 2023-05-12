#include <stdio.h>
int exprap(int,unsigned int,unsigned int);
int multimod(int a, unsigned int b, unsigned int n);


int main(){
    unsigned int n = (1 << 31); //n = 2^31
    n = n - 1;
    int a = 3;
    unsigned int b;
    while (scanf("%u", &b)>0){
        printf("%d\n", exprap(a,b,n));
        
    }
}

int exprap(int a,unsigned int b, unsigned int n){
    if(b==0){
        return 1;
    }
    else if((b%2)!=0){
        return multimod(exprap(a,b-1,n),a,n);
    }
    else{
        unsigned int x = exprap(a,b/2,n);
        return multimod(x,x,n);
    }
}

int multimod(int a, unsigned int b, unsigned int n){
    long long int la,lb;
    la = a;
    lb = b;
    return ((la*lb)%n);
}
