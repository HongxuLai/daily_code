void *lsearch(void *key, void *base, int n, int elemSize)
/* lsearch: in continued memory 'base', search for if there is the same
element as 'key' */
{
    for(int i = 0; i < n; i++)
    {
        void *elemAddr = (char*)base + i * elemSize; 
        // the address of element, (void *) can't do pointer calculation
        if (memcmp(key, elemAddr, elemSize) == 0)
        /* memcmp(a, b, n): compare a and b for n bytes times,
        return 0, <0 or >0 */
        {
            return elemAddr;
        }
    }
    return 0;
}