namespace CalculoFolha.Entidades
{
    interface IFolhaPagamento
    {
        Demonstrativo GerarDemonstrativo(int horasCategoria, 
                                         double salarioBase, 
                                         double horasExtras, 
                                         double horasDescontadas);
    }
}
