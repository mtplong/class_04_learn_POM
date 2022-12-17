package pageUIs.dataTable;

public class HomePageUI {
	public static final String PAGING_BY_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGING_BY_NUMBER_ACTIVED = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_NAME = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ICON_BY_COUNTRY_NAME = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
}
