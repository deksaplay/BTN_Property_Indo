import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

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

WebUI.setText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/input_penghasilan'), 
    penghasilan)

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/input_Pengeluaran'), 
    pengeluaran)

WebUI.takeScreenshot()

WebUI.selectOptionByIndex(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/select_Jangka Waktu'), 
    jangkaWaktu)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/button_Hitung'))

WebUI.takeScreenshot()

// Verifikasi bahwa harga properti telah dihitung dengan benar
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h3_harga'), 
    10)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h5_Harga Properti Maksimal Kamu'), 
    0)

// Verifikasi hasil perhitungan
WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/p_Langsung cari di area yang kamu inginkan'), 
    0)

WebUI.takeScreenshot()

//cara untuk mengonversi sebuah string menjadi tipe data double
def penghasilan = Double.parseDouble(penghasilan)
def pengeluaran = Double.parseDouble(pengeluaran)
//ekspresi yang digunakan untuk menghapus semua karakter non-digit dari string jangkaWaktu dan menyimpan hasilnya dalam variabel angka_bulan
String angka_bulan = jangkaWaktu.replaceAll("[^0-9]", "")

//sintaks tersebut mengonversi nilai yang disimpan dalam variabel angka_bulan (yang sebelumnya dihasilkan dari operasi replaceAll untuk menghapus karakter non-digit dari string)
// menjadi tipe data integer, dan hasilnya disimpan dalam variabel biljangkaWaktu.
def biljangkaWaktu = Integer.parseInt(angka_bulan)


def bilhasilKalkulasi = (penghasilan - pengeluaran) * (biljangkaWaktu * 12) / 3
println(bilhasilKalkulasi)
//sintaks tersebut memformat nilai yang disimpan dalam variabel bilhasilKalkulasi menjadi sebuah string dengan menggunakan pola format yang menghasilkan bilangan bulat tanpa desimal,
//dan hasilnya disimpan dalam variabel hasilKalkulasi.
String hasilKalkulasi = String.format ("%.0f", bilhasilKalkulasi)
println(hasilKalkulasi)

def bilDariWebsite = WebUI.getText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h3_harga'))
//ekspresi tersebut akan menghapus semua karakter non-digit dari string bilDariWebsite dan menyimpan hasilnya dalam variabel hasilDariWebsite. Sebagai contoh, jika bilDariWebsite adalah
//"Rp. 1.250.000", setelah operasi tersebut, hasilDariWebsite akan berisi "1250000".
String hasilDariWebsite = bilDariWebsite.replaceAll("[^0-9]", "")
WebUI.verifyEqual(hasilDariWebsite, hasilKalkulasi)
WebUI.takeScreenshot()

WebUI.closeBrowser()

//'Rp. ' + String.format('%,.0f', hargaProperti))
WebUI.closeBrowser()

