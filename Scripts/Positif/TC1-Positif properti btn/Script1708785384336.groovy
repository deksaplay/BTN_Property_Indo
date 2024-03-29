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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.reader.SheetPOI as SheetPOI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

// Mengambil data dari file Excel

TestData testData = TestDataFactory.findTestData('Data Excel Positif')

// Ambil jumlah baris data
int rowCount = testData.getRowNumbers()

// Looping untuk membaca setiap baris data
for (int i = 1; i <= rowCount; i++) {
	// Ambil nilai penghasilan, pengeluaran, dan jangkaWaktu dari kolom masing-masing
	def penghasilan = testData.getValue('penghasilan', i)

	def pengeluaran = testData.getValue('pengeluaran', i)

	def jangkaWaktu = testData.getValue('jangkaWaktu', i)

	// Buka browser dan kunjungi URL website
	WebUI.openBrowser('')

	WebUI.navigateToUrl('https://www.btnproperti.co.id/tools/hitung-harga-properti')

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
	WebUI.click(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/button_Hitung'))
	WebUI.takeScreenshot()
	// Ambil hasil perhitungan dari web
	String hargaPropertiWeb = WebUI.getText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h3_harga'))
	//verify element hitung
	WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h5_Harga Properti Maksimal Kamu'),
		2)
	
	WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/button_search'),
		2)
	
	WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/p_Langsung cari di area yang kamu inginkan'),
		2)
	
	WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h3_harga'),
		2)
	def penghasilanNumeric = Double.parseDouble(penghasilan)
	def pengeluaranNumeric = Double.parseDouble(pengeluaran)
	
	//ekspresi yang digunakan untuk menghapus semua karakter non-digit dari string jangkaWaktu dan menyimpan hasilnya dalam variabel angka_bulan
	
	String angka_bulan = jangkaWaktu.replaceAll("[^0-9]", "")
	//sintaks tersebut mengonversi nilai yang disimpan dalam variabel angka_bulan (yang sebelumnya dihasilkan dari operasi replaceAll untuk menghapus karakter non-digit dari string)
	// menjadi tipe data integer, dan hasilnya disimpan dalam variabel biljangkaWaktu.
	def biljangkaWaktuNumeric = Integer.parseInt(angka_bulan)
	
	
	def bilhasilKalkulasiNumeric = (penghasilanNumeric - pengeluaranNumeric) * (biljangkaWaktuNumeric * 12) / 3
	println(bilhasilKalkulasiNumeric)
	//sintaks tersebut memformat nilai yang disimpan dalam variabel bilhasilKalkulasi menjadi sebuah string dengan menggunakan pola format yang menghasilkan bilangan bulat tanpa desimal,
	String hasilKalkulasiNumeric = String.format ("%.0f", bilhasilKalkulasiNumeric)
	println(hasilKalkulasiNumeric)
	
	def bilDariWebsite = WebUI.getText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h3_harga'))
	//ekspresi tersebut akan menghapus semua karakter non-digit dari string bilDariWebsite dan menyimpan hasilnya dalam variabel hasilDariWebsite. Sebagai contoh, jika bilDariWebsite adalah
	//"Rp. 1.250.000", setelah operasi tersebut, hasilDariWebsite akan berisi "1250000".
	String hasilDariWebsiteNumeric = bilDariWebsite.replaceAll("[^0-9]", "")
	
	// Bandingkan hasil
	WebUI.comment("Data ke-" + i + ": Penghasilan = " + penghasilanNumeric + ", Pengeluaran = " + pengeluaranNumeric + ", Jangka Waktu = " + biljangkaWaktuNumeric)
	WebUI.comment("Hasil dari website: " + hasilDariWebsiteNumeric)
	WebUI.comment("Hasil Kalkulasi Lokal: " + hasilKalkulasiNumeric)

	// Bandingkan hasil dari website dengan hasil kalkulasi lokal
	
   assert hasilDariWebsiteNumeric == hasilKalkulasiNumeric

	  
WebUI.closeBrowser()
}

