#include<stdio.h>
#include<stdlib.h>

#define TAMANHO 20

void push(int* pilha, int** topo, int valor) {
	if(**topo >= TAMANHO - 1) {
		return;
	}
	
	(**topo)++;
	pilha[**topo] = valor;
}

int pop(int* pilha, int** topo) {
	if(**topo == -1) {
		return -1;
	}
	
	int removido = pilha[**topo];
	(**topo)--;
	
	return removido;
}

int top(int* pilha, int topo) {
  return pilha[topo];
}

int isEmpty(int* pilha, int** topo) {
  return (**topo == -1) ? 1 : 0;
}

int size(int* pilha, int topo) {
  int cont = 0;

  if (topo != -1) {
    for (int i = topo; i >= 0; i--) {
      cont ++;
    }
    return cont;
  } else {
    return 0;
  }

}

void clear(int* pilha, int** topo) {
  for (int i = **topo; i >= 0; i--) {
    (**topo)--;
  }
}

void imprimir(int* pilha, int topo) {
  if (topo == -1){
    printf("A pilha está vazia.\n\n");
  }
    
	for(int i = topo; i >= 0; i--) {
		printf("[%d]\n", pilha[i]);
	}
}


int main() {
  system("clear");
  
	int pilha[TAMANHO];
  int opt;
  int num = -1;
	int* topo = &num;

  do {
    printf("1. Inserir Valor na pilha (push())\n");
    printf("2. Remover Último Valor da pilha (pop())\n");
    printf("3. Retornar Último Valor da pilha (top())\n");
    printf("4. Verificar se a pilha está vazia (isEmpty())\n");
    printf("5. Verificar tamanho da pilha (size())\n");
    printf("6. Limpar pilha (clear())\n");
    printf("7. Imprimir pilha\n");
    printf("\n0. Finalizar Programa\n");
    
    printf("\nSelecione uma opção: ");
    scanf("%d", &opt);
  
    switch (opt) {
      case 1:
        system("clear");

        int valor;
        
        printf("1. Inserir Valor na pilha (push())\n\n");

        printf("Informe o valor que deseja inserir: ");
        scanf("%d", &valor);

        push(pilha, &topo, valor);

        printf("\nO valor %d foi inserido na pilha.\n\n", valor);
        break;
      
      case 2:
        system("clear");
        printf("2. Remover Último Valor da pilha (pop())\n\n");
        
        printf("O valor: %d foi removido da pilha\n\n", pop(pilha, &topo));
        
        break;
      
      case 3:
        system("clear");
        printf("3. Retornar Último Valor da pilha (top())\n\n");

        printf("O topo da pilha é: %d\n\n", top(pilha, *topo));
        break;
      
      case 4:
        system("clear");
        printf("4. Verificar se a pilha está vazia (isEmpty())\n\n");
        
        printf("A pilha %s.\n\n", (isEmpty(pilha, &topo)) ? "está vazia" : "contém elementos");
        
        break;
      
      case 5:
        system("clear");
        printf("5. Verificar tamanho da pilha (size())\n\n");

        printf("A pilha contém %d elemento(s).\n\n", size(pilha, *topo));
        break;
      
      case 6:
        system("clear");
        printf("6. Limpar pilha (clear())\n\n");

        clear(pilha, &topo);

        printf("A pilha %s.\n\n", (isEmpty(pilha, &topo)) ? "está vazia" : "contém elementos");
        break;
      
      case 7:
        system("clear");
        printf("7. Imprimir pilha\n\n");
        
        imprimir(pilha, *topo);
        break;
            
      case 0:
        system("clear");
        break;
      
      default:
        system("clear");
        printf("Opção inválida. Digite novamente...\n\n");
    }
  }	while (opt != 0);
  
  printf("Programa Finalizado");
  
	return 1;
}