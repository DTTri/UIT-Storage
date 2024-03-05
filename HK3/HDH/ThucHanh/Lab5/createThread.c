// // // // /*######################################
// // // // # University of Information Technology #
// // // // # IT007 Operating System
// // // // #
// // // // # <Your name>, <your Student ID> #
// // // // # File: example_thread_creation.c #
// // // // ######################################*/
// // // // #include <pthread.h>
// // // // #include <stdio.h>
// // // // void *thread_print(void * messenge) {
// // // // while(1) {  
// // // // printf("Hello, How are you?\n");
// // // // }
// // // // }
// // // // int main() {
// // // // pthread_t idthread;
// // // // pthread_create(&idthread,NULL,&thread_print,NULL);
// // // // while(1) {
// // // // printf("I’m fine, and you?\n");
// // // // }
// // // // return 0;
// // // // }
// // // /*######################################
// // // # University of Information Technology #
// // // # IT007 Operating System
// // // #
// // // # <Your name>, <your Student ID> #
// // // # File: example_thread_selfexit.c
// // // #
// // // ######################################*/
// // // #include <pthread.h>
// // // #include <stdio.h>
// // // #include <stdlib.h>
// // // #include <unistd.h>
// // // #define NUM_THREADS 2
// // // void *thread_print(void *threadid)
// // // {
// // // long tid;
// // // tid = (long)threadid;
// // // printf("Hello IT007! I’m Thread #%ld ^_^!!!\n", tid);

// // // pthread_exit(NULL);
// // // sleep(100);

// // // }
// // // int main()
// // // {
// // // pthread_t threads[NUM_THREADS];
// // // int check;
// // // long tID;
// // // for(tID = 0; tID < NUM_THREADS; tID++){
// // // printf("I’m Main Thread: create Thread: #%ld\n",tID);
// // // check = pthread_create(&threads[tID],NULL,thread_print,(void *)tID);
// // // if (check != 0){
// // // printf("ERROR!!! I’m Main Thread, can’t create Thread #%ld ", tID);
// // // exit(-1);
// // // }
// // // }

// // // /* Last thing that main() should do */
// // // pthread_exit(NULL);
// // // }


// // /*######################################
// // # University of Information Technology #
// // # IT007 Operating System
// // #
// // # <Your name>, <your Student ID> #
// // # File: example_thread_join.c
// // #
// // ######################################*/
// // #include <pthread.h>
// // #include <stdio.h>
// // #include <stdlib.h>
// // #include <unistd.h>
// // #define NUM_THREADS 2
// // void *thread_print(void *threadid)
// // {
// // long tid;
// // tid = (long)threadid;
// // printf("Hello IT007! I’m Thread #%ld ^_^!!!\n", tid);
// // }
// // int main()
// // {
// // pthread_t threads[NUM_THREADS];
// // int check;
// // long tID;
// // for(tID = 0; tID < NUM_THREADS; tID++){
// // printf("I’m Main Thread: create Thread: #%ld\n",
// // tID);
// // check = pthread_create(
// // &threads[tID],
// // NULL,
// // thread_print,
// // (void *)tID);
// // if (check != 0){
// // printf("ERROR!!! I’m Main Thread, Ican’t create Thread #%ld ", tID);
// // exit(-1);
// // } //end if
// // pthread_join(threads[tID], NULL);
// // } //end for
// // /* Last thing that main() should do */
// // pthread_exit(NULL);
// // }

// /*######################################
// # University of Information Technology #
// # IT007 Operating System
// #
// # <Your name>, <your Student ID> #
// # File: example_thread_structure.c #
// ######################################*/
// #include <pthread.h>
// #include <stdio.h>
// #define NUM_THREADS 2
// struct struct_print_parms{
// char character;
// int count;
// };
// void* char_print (void* args) {
//     struct struct_print_parms* p = (struct
// struct_print_parms*) args;
// int i;
// for (i=0; i <p->count; i++)
// printf ("%c\n", p->character);
// return NULL;
// }
// int main () {
// pthread_t tid;
// struct struct_print_parms th_args;
// th_args.character = 'X';
// th_args.count = 5;
// pthread_create(&tid, NULL, &char_print, &th_args);
// pthread_join (tid, NULL);
// return 0;
// }