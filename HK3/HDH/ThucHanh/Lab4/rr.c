#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include <limits.h>
#define SORT_BY_ARRIVAL 0
#define SORT_BY_PID 1
#define SORT_BY_BURST 2
#define SORT_BY_START 3

typedef struct{
    int iPID;
    int iArrival, iBurst;
    int iStart, iFinish, iWaiting, iResponse, iTaT;
    int iPause, iRemaining;
} PCB;

void inputProcess(int n, PCB P[]) {
    srand((unsigned) time(NULL));

    for (int i = 0; i < n; i++){
         P[i].iPID= i+1;
        P[i].iArrival = rand() % 21;
        P[i].iBurst = (rand()% 11) +2;
        P[i].iRemaining = P[i].iBurst;
        P[i].iPause = P[i].iArrival;
        P[i].iStart = P[i].iFinish = P[i].iResponse = P[i].iTaT = P[i].iWaiting = 0;
    }
}

void printProcess(int n, PCB P[]) {
    for (int i = 0; i < n; i++){
        printf("P%d(%d, %d)\n", P[i].iPID, P[i].iArrival, P[i].iBurst);
    }
}

void exportGanttChart (int n, PCB P[]) {
    printf("Gantt Chart:\n");
    printf("%d", P[0].iStart);
    for (int i = 0; i < n; i++){
        printf("___P[%d]___%d", P[i].iPID, P[i].iFinish);
    }
    printf("\n");
}

void pushProcess(int *n, PCB P[], PCB Q) {
    P[*n] = Q;
    (*n)++;
}

void removeProcess(int *n, int index, PCB P[]) {
    for(int i = index; i < *n; i++){
        P[i]=P[i+1];
    }
    (*n)--;
}
void swapProcess(PCB *P, PCB *Q) {
    PCB temp = *P;
    *P = *Q;
    *Q = temp;
}

int partition (PCB P[], int low, int high, int iCriteria) {
    if (iCriteria == SORT_BY_ARRIVAL) { 
        int pivot = P[high].iArrival;

        int i = (low-1);
   
        for(int j = low; j <= high; j++)
        {
            if (P[j].iArrival < pivot)
            {
                i++;
                swapProcess(&P[i], &P[j]);
            }
        }
        swapProcess(&P[i+1], &P[high]);
        return (i+1);
    } else if (iCriteria == SORT_BY_PID) { // Sort by PID
        int pivot = P[high].iPID;

        int i = (low-1);
   
        for(int j = low; j <= high; j++)
        {
            if (P[j].iPID < pivot)
            {
                i++;
                swapProcess(&P[i], &P[j]);
            }
        }
        swapProcess(&P[i+1], &P[high]);
        return (i+1);
    } else if (iCriteria == SORT_BY_BURST) {
        int pivot = P[high].iBurst;

        int i = (low-1);
   
        for(int j = low; j <= high; j++)
        {
            if (P[j].iBurst < pivot)
            {
                i++;
                swapProcess(&P[i], &P[j]);
            }
        }
        swapProcess(&P[i+1], &P[high]);
        return (i+1);
    } else if (iCriteria == SORT_BY_START) {
        int pivot = P[high].iStart;

        int i = (low-1);
   
        for(int j = low; j <= high; j++)
        {
            if (P[j].iStart < pivot)
            {
                i++;
                swapProcess(&P[i],&P[j]);
            }
        }
        swapProcess(&P[i+1], &P[high]);
        return (i+1);
    }
}

void quickSort(PCB P[], int low, int high, int iCriteria) {
    if(low < high) {
        
    int pi = partition(P, low, high, iCriteria);

    quickSort(P, low, pi-1, iCriteria);
    quickSort(P, pi+1, high, iCriteria);
    }
}

void calculateAWT(int n, PCB P[]) {
    int sum = 0; 
    float avg = 0;
    for (int i = 0; i < n; i++) {
        sum += P[i].iWaiting;
    }
    if (n > 0) avg = (float) sum/n;
    printf("Average Waiting time: %f\n", avg);
}

void calculateATaT(int n, PCB P[]) {
    int sum = 0;
    float avg = 0;
    for (int i = 0; i < n; i++) {
        sum += P[i].iTaT;
    }
    if (n > 0) avg = (float) sum/n;
    printf("Average Turnaround time: %f\n", avg);
}

int main()
{
    PCB Input[10];
    PCB ReadyQueue[10];
    PCB Temp[40];
    PCB TerminatedArray[10];
    int iNumberOfProcess;
    printf("Please input number of Process: ");
    scanf("%d", &iNumberOfProcess);
    int iRemain = iNumberOfProcess, iReady = 0, iTerminated = 0, iTemp = 0;
    inputProcess(iNumberOfProcess, Input);
    quickSort(Input, 0, iNumberOfProcess - 1, SORT_BY_ARRIVAL);
    printf("--Input--\n");
    printProcess(iRemain, Input);
    int q;
    printf("\nPlease input quantum time: ");
    scanf("%d", &q);
    pushProcess(&iReady, ReadyQueue, Input[0]);
    removeProcess(&iRemain, 0, Input);
    ReadyQueue[0].iStart = ReadyQueue[0].iArrival;
    ReadyQueue[0].iResponse = ReadyQueue[0].iStart - ReadyQueue[0].iArrival;
    bool flag=false;
    while (iTerminated < iNumberOfProcess) {
        if (ReadyQueue[0].iRemaining <= q)
            ReadyQueue[0].iFinish = ReadyQueue[0].iStart + ReadyQueue[0].iRemaining;
        else
            ReadyQueue[0].iFinish = ReadyQueue[0].iStart + q;
        while (iRemain > 0) {
            if (Input[0].iArrival <= ReadyQueue[0].iFinish) {
                flag=false;
                pushProcess(&iReady, ReadyQueue, Input[0]);
                removeProcess(&iRemain, 0, Input);
                continue;
            }
            else{
                      if(iReady==0){
                     flag=true;
                     pushProcess(&iReady, ReadyQueue, Input[0]);
                      removeProcess(&iRemain, 0, Input);
                      break;
                      }
                    else {flag=false;break;}
            }
        }
        if (iReady > 0) {
            ReadyQueue[0].iTaT += ReadyQueue[0].iFinish - ReadyQueue[0].iPause;
            ReadyQueue[0].iWaiting += ReadyQueue[0].iStart - ReadyQueue[0].iPause;
            ReadyQueue[0].iPause = ReadyQueue[0].iFinish;
            if (ReadyQueue[0].iRemaining <= q) {
                ReadyQueue[0].iRemaining = 0;
                pushProcess(&iTemp, Temp, ReadyQueue[0]);
                pushProcess(&iTerminated, TerminatedArray, ReadyQueue[0]);
                removeProcess(&iReady, 0, ReadyQueue);
            }
            else {
                ReadyQueue[0].iRemaining -= q;
                pushProcess(&iTemp, Temp, ReadyQueue[0]);
                pushProcess(&iReady, ReadyQueue, ReadyQueue[0]);
                removeProcess(&iReady, 0, ReadyQueue);
            }
            if(flag)  ReadyQueue[0].iStart = ReadyQueue[0].iArrival;
            else ReadyQueue[0].iStart = Temp[iTemp-1].iFinish;
            ReadyQueue[0].iResponse = ReadyQueue[0].iStart - ReadyQueue[0].iArrival;
        }
    }
    printProcess(iTerminated, TerminatedArray);
    printf("\n===== Round Robin Scheduling =====\n");
    exportGanttChart(iTemp, Temp);
    calculateAWT(iTerminated, TerminatedArray);
    calculateATaT(iTerminated, TerminatedArray);
    return 0;
}

