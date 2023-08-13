#include <malloc.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct no {
  int valor;
  struct no *prox;
} NO;

void imp_fila();
int num_elementos();
NO* remo_prim();

int main() {
  system("clear");
  
  NO* inicio = NULL;
  NO* fim = NULL;
  int opt, valor;

  printf("Sistema Iniciado...\n\n");
  
  do {
    printf("1. Inserir Valor na Fila\n");
    printf("2. Remover Primeiro Valor da Fila\n");
    printf("3. Remover Todos os Valores da Fila\n");
    printf("4. Imprimir Fila\n");
    printf("0. Finalizar Programa\n");
    
    printf("\nSelecione uma opção: ");
    scanf("%i", &opt);
    
    system("clear");

    printf("Opção: ");

    
    if (opt == 1) {    //1. Inserir Valor na Fila
      printf("1. Inserir Valor na Fila\n\n");

      printf("Digite o valor que deseja inserir: ");
      scanf("%d", &valor);
      
      NO* n = (NO*) malloc(sizeof(NO));
      n->valor = valor;
      n->prox = NULL;
      
      if (inicio == NULL){
        inicio = n;
        fim = n;
      } else {
        fim->prox = n;
        fim = n;
      }

      printf("\nExiste(m) %d número(s) na fila\n", num_elementos(inicio));
      
      printf("\n");


    }  else if (opt == 2) {   //2. Remover Primeiro Valor da Fila
      printf("2. Remover Primeiro Valor da Fila\n\n");
      inicio = remo_prim(inicio);

      printf("\nExiste(m) %d número(s) na fila\n\n", num_elementos(inicio));  

    } else if (opt == 3) {     //3. Remover Todos os Valores da Fila
      printf("3. Remover Todos os Valores da Fila\n\n");

      while (inicio != NULL) {
        inicio = remo_prim(inicio);
      }

      printf("\nA FILA ESTÁ VAZIA!\n\n");
      
      
    } else if (opt == 4) {     //4. Imprimir Fila
      printf("4. Imprimir Fila\n\n");

      imp_fila(inicio);
      
      
    } else if (opt > 4 || opt < 0){
      printf("Opção inválida\n\n");
    }

  } while (opt != 0);    //0. Finalizar Programa
  
  printf("0. Finalizar Programa");
  printf("\n\nPrograma encerrado!");
  
  return 0;
}

NO* remo_prim(NO* inicio) {
  NO* aux = inicio;

  inicio = aux->prox;
      
  int val_rem = aux->valor;
      
  free(aux);
      
  printf("Valor \"%d\" removido com sucesso!\n", val_rem);

  return inicio;
}

void imp_fila(NO* inicio) {
  NO* aux = inicio; 
  printf("FILA:\n");
      
  while (aux != NULL){
    printf("[%d]", aux->valor);
    aux = aux->prox;
  }

  if (inicio == NULL) {
    printf("Fila vazia. Adicione um valor selecionando a opção 1.\n");
  } 
  
  printf("\n\n");
}

int num_elementos(NO* inicio) {
  NO* aux = inicio; 

  int cont = 0;
  
  while (aux != NULL){
    cont++;
    aux = aux->prox;
  }

  return cont;
}