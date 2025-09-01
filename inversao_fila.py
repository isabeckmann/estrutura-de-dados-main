# Aluna Isadora Beckmann
# O objetivo do programa é inverter uma fila original, utilizando apenas pilhas e filas auxiliares.

from collections import deque

# Implementação de Fila
# enqueue(item) → insere elemento no fim, dequeue() → remove elemento do início, is_empty() → verifica se a fila está vazia.
# A impressão (__str__) mostra os elementos da esquerda para a direita, ex: A → B → C → D.
class Fila:
    def __init__(self):
        self.itens = deque()

    def enqueue(self, item):
        self.itens.append(item)  # adiciona no final

    def dequeue(self):
        if not self.is_empty():
            return self.itens.popleft()  # remove do início

    def is_empty(self):
        return len(self.itens) == 0

    def __str__(self):
        return " → ".join([str(x) for x in self.itens])


# Implementação de Pilha
# push(item) → empilha elemento no topo, pop() → desempilha elemento do topo, is_empty() → verifica se a pilha está vazia.
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


# Função para inverter a fila usando apenas Pilha
# 1°: Transferir da fila para a pilha.
# Enquanto a fila não está vazia, removemos (dequeue) o elemento e o empilhamos (push). Invertando a ordem, pois a pilha é LIFO.
# 2°: Transferir da pilha para a nova fila.
# Enquanto a pilha não está vazia, desempilhamos (pop) e enfileiramos (enqueue) na nova fila. Preservando a ordem invertida na fila final.
def inverter_fila(fila_original):
    pilha_aux = Pilha()
    fila_invertida = Fila()

    # Passo 1: da fila para a pilha
    while not fila_original.is_empty():
        pilha_aux.push(fila_original.dequeue())

    # Passo 2: da pilha para a nova fila
    while not pilha_aux.is_empty():
        fila_invertida.enqueue(pilha_aux.pop())

    return fila_invertida


# Lógica principal
# O usuário informa quantos e quais elementos quer enfileirar, cada um é colocado na fila original usando enqueue.
fila = Fila()

# Entrada do usuário
n = int(input("Quantos elementos deseja enfileirar? "))

for i in range(n):
    valor = input(f"Digite o elemento {i+1}: ")
    fila.enqueue(valor)

# Primeiro, mostra a fila original. 
print("\nFila original:", fila)

# Depois, mostra a fila invertida.
fila_invertida = inverter_fila(fila)
print("Fila invertida:", fila_invertida)
