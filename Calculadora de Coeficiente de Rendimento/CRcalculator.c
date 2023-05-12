#include <stdio.h>

int main(){
    float credxnota=0;
    int somacred=0;
    int n_materias;
    int materia=1;
    float nota=-1;
    int credito=-1;
    FILE *parq;
    
    parq = fopen("notas.txt","r");
    while(!feof(parq)){
       fscanf(parq,"%f %d", &nota, &credito);
       
       
        credxnota += nota*credito;
        somacred += credito; 
       
       
    }
    printf("CR é %.2f\n", credxnota/somacred);
    fclose(parq);
    parq = NULL;

    return 0;
}