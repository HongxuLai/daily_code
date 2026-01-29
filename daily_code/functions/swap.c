void swap(void *vp1, void *vp2, int size)
{
    char buffer[size];
    memcpy(buffer, vp1, size);
    memcpy(vp1, vp2, size);
    memcpy(vp2, buffer, size);
}

/* 
swap changes the memory's content represented by the address

char *husband = strdup("Fred");
char *wife = stdrup("Wilma");
swap(&husband, &wife, sizeof(char *))

stack                            heap
0x2000-husband -> 0x5000         0x5000:'F','r','e','d','\0'
0x2008-wife -> 0x6000            0x6000:'W','i','l','m','a','\0'
after swap:
0x2000-husband -> 0x6000 
0x2008-wife -> 05000 
*/
