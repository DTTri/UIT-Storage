#include <stdio.h>
#include <semaphore.h>
#include <pthread.h>

int sells=0;
int products=0;
sem_t sem1, sem2;

void *processA(void* messenge){
while(1){
    sem_wait(&sem1);
    sells++;
    printf("Sell: %d\n", sells);
    sem_post(&sem2);
}
}

void *processB(void* messenge){
while(1){
    sem_wait(&sem2);
    products++;
    printf("Products: %d\n", products);
    sem_post(&sem1);
}
}

int main(){
sem_init(&sem1, 0,0);
sem_init(&sem2, 0,1517);
pthread_t pA,pB;
pthread_create(&pA,NULL,&processA,NULL);
pthread_create(&pB, NULL, &processB, NULL);
while(1){}
}