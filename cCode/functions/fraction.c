
struct fraction
{
    int num;
    int denom;
};
fraction pi;
pi.num = 22;
pi.denom = 7;
(fraction*)&(pi.denom) -> num = 12;
(fraction*)&(pi.denom) -> denom = 33;

