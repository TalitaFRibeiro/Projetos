#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>

int modd = 100000007;
int *contar_repeticao = NULL;
char *palavra = NULL;
void contando_repeticao(void);
unsigned long int multimod(long long int, unsigned long long int, unsigned int);
int InvMod(int, int);
int MDCE(int, int, int &,int &);
long long unsigned int fatorial(int);

int main(){
    int i = 1<<14;
    palavra = (char *) malloc(i *sizeof(char));
    
    while(true){
        contar_repeticao = (int *) calloc(30, sizeof(int));
        scanf("%s", palavra);
        if(palavra[0]=='0'){
            break;

        }
        else{
            
            contando_repeticao();
        }
    }
    for(int i = 0; i< strlen(palavra); i++){
        palavra[i] = ' ';
    }
    free(palavra);
    free(contar_repeticao);
}

void contando_repeticao(){
    int n = (unsigned) strlen(palavra);
    int auxi = 0;
    int resto = -1;
    for(int j = 0; j<30; j++){
        contar_repeticao[j] = 0;
    }
    for(int i = 0; i<n; i++){
        auxi = palavra[i];
        resto = auxi % 97;
        
        if(resto< 123){
            contar_repeticao[resto] +=1;
        }
        resto = -1;
    }
    int produtos = 1;
    for(int i = 0; i<30; i++){
        if(contar_repeticao[i]>0){
            produtos = multimod(fatorial(contar_repeticao[i]), produtos, modd); 
        }
    }
   
    int inve = InvMod(produtos, modd);
    int fatden = fatorial(n);
    int resultado = multimod(fatden, inve, modd);
    printf("%d\n", resultado);
    
}

unsigned long int multimod(long long int a, unsigned long long int b, unsigned int n){
    long long int la,lb;
    la = a%n;
    lb = b%n;
    return ((la*lb)%n);
}

int InvMod(int b, int n){
    int x;
    int y;
    int d = MDCE(b, n, x, y);
    return ((x+n) % n);
}

int MDCE(int a, int b, int &x,int &y){
    if(b==0){
        x = 1; 
        y = 0;
        return a;
    }
    else{
        int xa;
        int ya;
        int d = MDCE(b, a%b, xa, ya);
        x = ya;
        y = xa - floor(a/b) * ya;
        return d;
    }
} 

long long unsigned int fatorial(int n){
    if(n == 1){
        return n;
    }
    else if(n==0){
        return 1;
    }
    else{
        return multimod(n,  fatorial(n-1) ,  100000007 );
    }
}
