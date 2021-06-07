#include <stdio.h>
#include "list.h"

typedef struct list 
{
    struct list *first;

}list_t;

list_t *list_new()
{
    list_t *list;
    list = malloc(sizeof(list_t));
    list->first = NULL;
    return list;
}

bool list_insert(list_t *list, int value)
{
    list = malloc(sizeof(list_t));
    list->value = value;
    

}