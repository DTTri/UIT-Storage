#include<stdlib.h>
#include<semaphore.h>
#include<pthread.h>
#include<stdio.h>
int x1=5, x2=10, x3=15, x4=20, x5=25, x6=30, w=0, v=0, y=0, z=0, ans=0;
sem_t semAB, semCD, semCD2, semEF, semEF2, semG, semBusy;

void* processAB(void* messenge){
    while(1){
        sem_wait(&semG);
        sem_wait(&semBusy);
        w = x1*x2;
        v = x3*x4;
        printf("w = %d\n",w);
        printf("v = %d\n", v);
        sem_post(&semCD2);
        sem_post(&semAB);
        sem_post(&semBusy);
    }
}

void* processCD(void* messenge){
    while(1){
        sem_wait(&semCD2);
        sem_wait(&semAB);
        sem_wait(&semBusy);
        y= v*x5;
        z = v*x6;
        printf("y = %d\n",y);
        printf("z = %d\n", z);
        sem_post(&semAB);
        sem_post(&semCD);
        sem_post(&semEF2);
        sem_post(&semBusy);
    }
}

void* processEF(void* messenge){
    while(1){
        sem_wait(&semEF2);
        sem_wait(&semCD);
        sem_wait(&semAB);
        sem_wait(&semBusy);
        y= w * y;
        z= w * z;
        printf("y = %d\n",y);
        printf("z = %d\n", z);
        sem_post(&semEF);
        sem_post(&semBusy);
    }
}

void* processG(void* messenge){
    while(1){
        sem_wait(&semEF);
        sem_wait(&semBusy);
        ans = y+z;
        printf("ans = %d\n", ans);
        sem_post(&semBusy);
        sem_post(&semG);
    }
}
int main() {
pthread_t pAB, pCD, pEF, pG;
sem_init(&semAB, 0, 0);
sem_init(&semCD, 0, 0);
sem_init(&semCD2, 0, 0);
sem_init(&semEF, 0, 0);
sem_init(&semEF2, 0, 0);
sem_init(&semG, 0, 1);
sem_init(&semBusy, 0, 1);
pthread_create(&pAB, NULL, &processAB, NULL);
pthread_create(&pCD, NULL, &processCD, NULL);
pthread_create(&pEF, NULL, &processEF, NULL);
pthread_create(&pG, NULL, &processG, NULL);
while (1){}
return 0;
}