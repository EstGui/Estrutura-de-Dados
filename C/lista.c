#include <malloc.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct no {
  int valor;
  struct no *prox;
} NO;

void add_value();
void imp_list();
int num_elementos();
bool proc_valor();

int main() {
  system("clear");
  
  NO* inicio = NULL;
  NO* fim = NULL;
  int opt, valor, pos;
  bool stts;

  printf("Sistema Iniciado...\n\n");
  
  do {
    printf("1. Inserir Valor na Lista\n");
    printf("2. Inserir Valor na Posição da Lista\n");
    printf("3. Remover Último Valor da Lista\n");
    printf("4. Remover Valor da Lista\n");
    printf("5. Remover Posição da Lista\n");
    printf("6. Pesquisar Valor na Lista\n");
    printf("7. Imprimir Lista\n");
    printf("0. Finalizar Programa\n");
    
    printf("\nSelecione uma opção: ");
    scanf("%i", &opt);
    
    system("clear");

    printf("Opção: ");

    
    if (opt == 1) {    //1. Inserir Valor na Lista
      printf("1. Inserir Valor na Lista\n\n");

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

      printf("\nExiste(m) %d número(s) na lista\n", num_elementos(inicio));
      
      printf("\n");


    } else if (opt == 2) {   //2. Inserir Valor na Posição da Lista
      printf("2. Inserir Valor na Posição da Lista\n\n");
      
      printf("Digite o valor que deseja inserir: ");
        scanf("%d", &valor);

      NO* n = (NO*) malloc(sizeof(NO));
      n->valor = valor;
      
      printf("Digite a posicão que deseja adicionar o valor: ");
        scanf("%d", &pos);

      if (pos > num_elementos(inicio) || pos < 0){
        printf("\nPosição escolhida não existe\n\n");
        continue;
      }

      NO* aux = inicio;
      NO* ant;
      
      for (int i = 0; i < pos-1; i ++){ 
        ant = aux;
        aux = aux->prox;
      }
      
      n->prox = aux;
      ant->prox = n;

      printf("\nValor adicionado à lista\n");
      printf("\nExiste(m) %d número(s) na lista\n\n", num_elementos(inicio));

      
    } else if (opt == 3) {   //3. Remover Último Valor da Lista
      printf("3. Remover Último Valor da Lista\n\n");

      NO* aux = inicio;
      NO* ant = inicio;
  
      while (aux->prox != NULL) {
        ant = aux;
        aux = aux->prox;
      }
      
      int val_rem = aux->valor;
      
      free(aux);

      if (ant->valor == aux->valor) {
        inicio = NULL;
      } 
      fim = ant;
      ant->prox = NULL;
      
      printf("Valor \"%d\" removido com sucesso!\n", val_rem);

      printf("\nExiste(m) %d número(s) na lista\n\n", num_elementos(inicio));

      
    } else if (opt == 4) {     //4. Remover Valor da Lista
      printf("4. Remover Valor da Lista\n\n");

      imp_list(inicio);
      
      printf("Digite o valor que deseja remover:");
      scanf("%d", &valor);

      stts = proc_valor(inicio, valor);

      if (stts) {
        NO* aux = inicio;
        NO* ant = inicio;
  
        while (aux->valor != valor) {
          ant = aux;
          aux = aux->prox;
        }
  
        if (ant->valor == aux->valor){
          inicio = aux->prox;
          free(aux); 
        }  else {
          ant->prox = aux->prox;
          free(aux); 
          if(ant->prox == NULL) {
            fim = ant;
          }
        }
  
        printf("\nO valor \"%d\" foi removido com sucesso.\n", valor);
  
        printf("\nExiste(m) %d valor(es) na lista\n", num_elementos(inicio));
      } else {
        printf("\nValor não encontrado na lista\n\n");
      }
      
      
    } else if (opt == 5) {     //5. Remover Posição da Lista
      printf("5. Remover Posição da Lista\n\n");

      imp_list(inicio);
      
      printf("Digite a posição que deseja remover: ");
      scanf("%d", &pos);

      if (pos > num_elementos(inicio) || pos < 0){
        printf("\nPosição escolhida não existe\n\n");
        continue;
      }
      
      NO* aux = inicio;
      NO* ant = inicio;
      
      for (int i = 0; i != pos-1; i++) {
        ant = aux;
        aux = aux->prox;
      }

      int val_rem = aux->valor;
      
      if (ant->valor == aux->valor){
        inicio = aux->prox;
        free(aux); 
      } else {
        ant->prox = aux->prox;
        free(aux); 
        fim = ant;
      }

      printf("\nValor \"%d\" da posição %d removido com sucesso.\n", val_rem, pos);

      printf("\nExiste(m) %d valor(es) na lista\n", num_elementos(inicio));
      
      
    } else if (opt == 6) {     //6. Pesquisar Valor na Lista
      printf("6. Pesquisar Valor na Lista\n\n");

      printf("Digite o valor que deseja pesquisar: ");
      scanf("%d", &valor);
      
      NO* aux = inicio;
      NO* ant = inicio;
      bool stts = false;

      int cont = 1;
      while (aux != NULL) {
        if (aux->valor == valor){
          stts = true;
          break;
        }
        cont++;
        ant = aux;
        aux = aux->prox;
      } 

      if (stts) {
        printf("\nO valor foi encontrado na lista na posição %d\n\n", cont);
      } else {
        printf("\nValor não encontrado na lista.\n\n");
      }

      
    } else if (opt == 7) {     //7. Imprimir Lista
      printf("7. Imprimir lista\n\n");

      imp_list(inicio);
      
      
    } else if (opt >= 8 || opt < 0){
      printf("Opção inválida\n\n");
    }

  } while (opt != 0);    //0. Finalizar Programa
  
  printf("0. Finalizar Programa");
  printf("\n\nPrograma encerrado!");
  
  return 0;
}

void imp_list(NO* inicio) {
  NO* aux = inicio; 
  printf("LISTA:\n");
      
  while (aux != NULL){
    printf("[%d]\n", aux->valor);
    aux = aux->prox;
  }

  if (inicio == NULL) {
    printf("Lista vazia. Adicione um valor selecionando a opção 1.\n");
  } 
  
  printf("\n");
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

bool proc_valor(NO* inicio, int valor){
  NO* aux = inicio;
  NO* ant = inicio;
  bool stts = false;

  while (aux != NULL) {
    if (aux->valor == valor){
      stts = true;
      break;
    }
    ant = aux;
    aux = aux->prox;
  }

  return stts;
}