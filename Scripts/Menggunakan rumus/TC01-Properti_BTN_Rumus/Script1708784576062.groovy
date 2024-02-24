import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://www.btnproperti.co.id/tools/hitung-harga-properti')
WebUI.maximizeWindow()
// Verify element page kpr

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_Ajukan KPR'),
	2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_Blog'), 2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_List Developer'),
	2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_Promo'), 2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_Tools'), 2)

// Masukkan nilai penghasilan
WebUI.setText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/input_penghasilan'),
	penghasilan)
WebUI.takeScreenshot()
// Masukkan nilai pengeluaran
WebUI.setText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/input_Pengeluaran'),
	pengeluaran)
WebUI.takeScreenshot()

// Masukkan nilai jangka waktu
WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/select_Jangka Waktu'),
	jangkaWaktu)
WebUI.takeScreenshot()
// Klik tombol hitung
WebUI.click(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/button_Hitung'))
WebUI.takeScreenshot()

//verify element hitung
WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h5_Harga Properti Maksimal Kamu'),
	2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/button_search'),
	2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/p_Langsung cari di area yang kamu inginkan'),
	2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h3_harga'),
	2)



 	def penghasilan = Double.parseDouble(penghasilan)
	def pengeluaran = Double.parseDouble(pengeluaran)
	String angka_bulan = jangkaWaktu.replaceAll("[^0-9]", "")
	def biljangkaWaktu = Integer.parseInt(angka_bulan)
	
	
	def bilhasilKalkulasi = (penghasilan - pengeluaran) * (biljangkaWaktu * 12) / 3
	println(bilhasilKalkulasi)
	String hasilKalkulasi = String.format ("%.0f", bilhasilKalkulasi)
	println(hasilKalkulasi)
	
	def bilDariWebsite = WebUI.getText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h3_harga'))
	
	String hasilDariWebsite = bilDariWebsite.replaceAll("[^0-9]", "")
	WebUI.verifyEqual(hasilDariWebsite, hasilKalkulasi)
	WebUI.takeScreenshot()
	
WebUI.closeBrowser()


	



