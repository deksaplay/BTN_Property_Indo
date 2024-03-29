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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.reader.SheetPOI as SheetPOI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

// Mengambil data dari file Excel
TestData testData = TestDataFactory.findTestData('Data Excel')

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

// Masukkan nilai penghasilan
WebUI.setText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/input_penghasilan'), 
    penghasilan)

// Masukkan nilai pengeluaran
WebUI.setText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/input_Pengeluaran'), 
    pengeluaran)

// Masukkan nilai jangka waktu
WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/select_Jangka Waktu'), 
    jangkaWaktu)

// Klik tombol hitung
WebUI.click(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/button_Hitung'))


// Ambil hasil perhitungan dari web
String hargaPropertiWeb = WebUI.getText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/h3_harga'))
}


