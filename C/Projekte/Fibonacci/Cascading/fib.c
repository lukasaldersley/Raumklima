#include <stdio.h>
#include <time.h>

unsigned long long fib(unsigned long long nr) {
	if (nr == 0 || nr == 1) {
		return 1;
	}
	else {
		return fib(nr - 1) + fib(nr - 2);
	}
}

void main() {
	FILE *fp;
	fp = fopen("FiboKaskResult.txt", "a");
	if (fp == NULL) {
		printf("KEINE AUFZEICHNNG DER BENOETIGTEN ZEIT");
	}
	unsigned long long target;
	printf("\n\nBitte Fibonacci-Nummer eingeben: ");
	scanf("%llu", &target);
	printf("\nBereche alle Fibonacci zahlen bis %llu...\n", target);
	clock_t t;
	t = clock();
	for (unsigned long long i = 0; i <= target; i++) {
		printf("%llu => %llu\n", i, fib(i));
	}
	t = clock() - t;
	float f = ((float)t) / CLOCKS_PER_SEC;
	int d = f / (3600 * 24);
	int h = (f - (d * 3600 * 24)) / 3600;
	int m = (f - (d * 3600 * 24 + h * 3600)) / (60);
	int s = (f - (d * 3600 * 24 + h * 3600 + m * 60)); //(79 - (0 * 3600 * 24 + 0 * 3600 + 1 * 60))
	int ms = (f - (int)(f)) * 1000;
	printf("Benoetigte Zeit fuer die ersten %llu Fibonacci - Zahlen: %f Sekunden (= %id, %ih, %im, %is, %ims)\n", target, f, d, h, m, s, ms);
	if (!(fp == NULL)) {
		fprintf(fp, "Benoetigte Zeit fuer die ersten %llu Fibonacci-Zahlen: %f Sekunden\n", target, f);
	}
	fclose(fp);
}