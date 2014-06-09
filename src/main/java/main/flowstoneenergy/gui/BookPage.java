package main.flowstoneenergy.gui;

public class BookPage
{
    private int startNDX = 0;
    private int endNDX = 12;
    private ItemGuiManual parent;

    public BookPage(ItemGuiManual parent, int startIndex)
    {
        this.parent = parent;
        this.startNDX = startIndex;
    }

    public void RenderPage()
    {

    }

    public void RenderHaunches()
    {
        int i1 = 5;

        for (int i = 0; i < 10; ++i)
        {
            int i4 = 16;
            byte b4 = 0;
        }
    }
}