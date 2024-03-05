#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>  // Thêm thư viện này
#define MAX_LINE 256

int main(void) {
  char line[MAX_LINE];
  char *args[MAX_LINE / 2 + 1];

  while (1) {
    // Hiển thị lời nhắc
    printf("it007sh> ");
    fflush(stdout);

    // Đọc lệnh từ người dùng
    fgets(line, MAX_LINE, stdin);

    // Phân tích cú pháp lệnh
    int argc = 0;
    args[argc++] = strtok(line, " ");
    while ((args[argc++] = strtok(NULL, " ")) != NULL);

    // Fork một tiến trình con
    pid_t pid = fork();
    if (pid == 0) {
      // Thực thi lệnh trong tiến trình con
      execvp(args[0], args);
      // Nếu execvp thất bại, chương trình sẽ kết thúc
      exit(1);
    } else {
      // Chờ đợi tiến trình con kết thúc
      waitpid(pid, NULL, 0);
    }
  }

  return 0;
}