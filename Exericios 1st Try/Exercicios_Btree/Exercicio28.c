#include <stdio.h>

#define MAX_MARCA 21
#define MAX_MODELO 21

struct carro{
    char marca[MAX_MARCA];    //21 bytes
    char modelo[MAX_MODELO];  //21 bytes
    short cilindrada;         //2 bytes
    short ano_introducao;     //2 bytes
    short ano_retirada;       //2 bytes
};  //total = 48 bytes

struct bt_node{
    short n;  //ocupação, quantos elementos tem o no, pode ser int  //2 bytes
    struct carro elementos[2 * T - 1];     //48 * (2* T - 1) bytes
    //+ 2 bytes de alinhamento
    int filhos[2*T];                    //4 * 2*T bytes
    bool eh_Leaf;                  //1 byte
    //+ 3 bytes de alinhamento
};

