import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class Articles2ShopTest {

    private StockService stockServiceStrictMock;
    private Articles2Shop articles2Shop;
    private Currency currency;
    private int quantity;

    @BeforeEach
    void setUP() {
        stockServiceStrictMock = EasyMock.createStrictMock(StockService.class);
        articles2Shop = new Articles2Shop(stockServiceStrictMock);
        currency = new Currency(20, "€");
        quantity = 2;
        articles2Shop.setStocks(stockServiceStrictMock);
    }

    @org.junit.jupiter.api.Test
    void addArticleMinQuantity() {
        stockServiceStrictMock.buy(anyObject());
        expectLastCall().times(2);
        expectLastCall().andThrow(new IllegalArgumentException());
        EasyMock.expect(stockServiceStrictMock.getPrix(anyObject())).andReturn(currency);

        replay(stockServiceStrictMock);

        articles2Shop.addArticleMinQuantity("EasyMock Book", 3);

        Article article = new Article("EasyMock Book", currency);

        assertTrue(articles2Shop.getPanier().contains(article));
        assertEquals(articles2Shop.getPanier().get(articles2Shop.getPanier().indexOf(article)).getQuantity(), 2);

        verify(stockServiceStrictMock);
    }

    @org.junit.jupiter.api.Test
    void addArticleStrictQuantity() {
        expect(stockServiceStrictMock.available(anyObject())).andReturn(quantity+1);
        stockServiceStrictMock.buy(anyObject());
        expectLastCall().times(quantity);
        EasyMock.expect(stockServiceStrictMock.getPrix(anyObject())).andReturn(currency);

        replay(stockServiceStrictMock);

        articles2Shop.addArticleStrictQuantity("EasyMock Book", quantity);

        Article article = new Article("EasyMock Book", currency);

        assertTrue(articles2Shop.getPanier().contains(article));
        assertEquals(articles2Shop.getPanier().get(articles2Shop.getPanier().indexOf(article)).getQuantity(), quantity);

        verify(stockServiceStrictMock);
    }

    @org.junit.jupiter.api.Test
    void addArticleStrictQuantityBoundary() {
        expect(stockServiceStrictMock.available(anyObject())).andReturn(0);

        replay(stockServiceStrictMock);

        articles2Shop.addArticleStrictQuantity("EasyMock Book", quantity);

        Article article = new Article("EasyMock Book", currency);

        assertFalse(articles2Shop.getPanier().contains(article));

        verify(stockServiceStrictMock);
    }
    
    @org.junit.jupiter.api.Test
    void addArticleMinQuantityBoundary() {
        stockServiceStrictMock.buy(anyObject());
        expectLastCall().andThrow(new IllegalArgumentException());

        replay(stockServiceStrictMock);

        articles2Shop.addArticleMinQuantity("EasyMock Book", 3);

        Article article = new Article("EasyMock Book", currency);

        assertFalse(articles2Shop.getPanier().contains(article));

        verify(stockServiceStrictMock);
    }



}
