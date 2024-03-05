#include <stdio.h>
#include <semaphore.h>
#include <pthread.h>
#include <stdlib.h>
#include <time.h>

int n=0;
int arr[1000000];
sem_t sem;
pthread_mutex_t mutex;
void remove_arr(int pos)
{
    for(int i=pos; i<n-1;i++)
    {
        arr[pos] = arr[pos+1];
    }
}

void *processA(void* messenge){
while(1){
    pthread_mutex_lock(&mutex);
    srand(time(0));
    ++n;
    arr[n-1]= rand();
    printf("After add:%d\n",n); // so phan tu trong arr
    sem_post(&sem);
    pthread_mutex_unlock(&mutex);
}

}

void *processB(void* messenge){
    int pos=0;
while(1){
    // neu dat sem o day thi Nothing in array se khong bao gio duoc in ra
    if(n==0) {
        printf("Nothing in array\n");
    }
    sem_wait(&sem);
    pthread_mutex_lock(&mutex);
    srand(time(0));
    int pos= rand()% n;
    remove_arr(pos);
    --n;
    printf("After remove:%d\n",n);
    pthread_mutex_unlock(&mutex);
}
}

int main(){
pthread_t pA,pB;
sem_init(&sem,0,0);
pthread_mutex_init(&mutex,NULL);
pthread_create(&pA,NULL,&processA,NULL);
pthread_create(&pB, NULL, &processB, NULL);
while(1){}
}