int StrCmp(void *vp1, void *vp2)
{
    char *s1 = *(char**)vp1;
    char *s2 = *(char**)vp2;
    return strcmp(s1, s2);
}

char *notes[] = {"Ab", "F#", "B", "Gb", "D"};
char *favoriteNote = "Eb";
char **found = lsearch(&favoriteNote, notes, 5, sizeof(char*), StrCmp);