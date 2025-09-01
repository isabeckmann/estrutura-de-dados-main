# Aluna Isadora Beckmann, engenharia de software

# O programa foi dividido em três partes: a entrada dos dados, processo de inversão e saída do resultado.
from collections import deque

# Implementação simples de Pilha com as operações: push(self, item) para empilhar,
# pop(self) para desempilhar e is_empty(self) para verificar se está vazia.
# A impressão da pilha mostra os elementos do topo para a base.
class Pilha:
    def __init__(self):
        self.itens = []

    def push(self, item):
        self.itens.append(item)

    def pop(self):
        if not self.is_empty():
            return self.itens.pop()

    def is_empty(self):
        return len(self.itens) == 0

    def __str__(self):
        # Mostrar do topo para a base
        return " | ".join(reversed([str(x) for x in self.itens]))


# Implementação simples de Fila com as operações: enqueue(self, item) para enfileirar adicionando no fim,
# dequeue(self) para desenfileirar removendo do início e is_empty(self) para verificar se está vazio.
class Fila:
    def __init__(self):
        self.itens = deque()

    def enqueue(self, item):
        self.itens.append(item)

    def dequeue(self):
        if not self.is_empty():
            return self.itens.popleft()

    def is_empty(self):
        return len(self.itens) == 0


# Função para inverter a pilha usando apenas Pilha e Fila.
# A inversão ocorre em dois passos: 
# 1°: transferir da pilha para a fila, enquanto a pilha não está vazia ele desempilha (pop) da pilha original e
# enfileira (enqueue) esse elemento na fila, mudando a ordem porque a pilha remove do topo e a fila mantém em ordem de chegada.
def inverter_pilha(pilha_original):
    fila_aux = Fila()
    pilha_invertida = Pilha()

    # Passo 1: passar da pilha para a fila
    while not pilha_original.is_empty():
        fila_aux.enqueue(pilha_original.pop())

    # Passo 2: passar da fila para a nova pilha
    while not fila_aux.is_empty():
        pilha_invertida.push(fila_aux.dequeue())

    return pilha_invertida


# O usuário informa quantos elementos deseja empilhar e digita cada elemento.
# Cada valor é empilhado na pilha original.
pilha = Pilha()

# Entrada do usuário
n = int(input("Quantos elementos deseja empilhar? "))

for i in range(n):
    valor = input(f"Digite o elemento {i+1}: ")
    pilha.push(valor)

# O programa mostra a pilha original (antes da inversão).
print("\nPilha original (topo -> base):", pilha)

# Invertendo a pilha
pilha_invertida = inverter_pilha(pilha)

# Em seguida, mostra a pilha invertida.
print("Pilha invertida (topo -> base):", pilha_invertida)
