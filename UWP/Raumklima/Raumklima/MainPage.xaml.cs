using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using Windows.Devices.Bluetooth;
using Windows.Devices.Bluetooth.Rfcomm;
using Windows.Devices.Enumeration;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.Networking.Sockets;
using Windows.Storage.Streams;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;
using System.Diagnostics;

// Die Elementvorlage "Leere Seite" wird unter https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x407 dokumentiert.

namespace Raumklima
{
    /// <summary>
    /// Eine leere Seite, die eigenständig verwendet oder zu der innerhalb eines Rahmens navigiert werden kann.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        private StreamSocket _socket;
        private RfcommDeviceService _service;

        public MainPage()
        {
            this.InitializeComponent();
        }

        private async void ConnectToDeviceButton_Click(object sender, RoutedEventArgs e)
        {
            await Send();
        }

        private async Task Send()
        {
            if (await Connect())
            {
                Debug.WriteLine("SUCCEDED...DATA SHOULD BE ON THE WAY");
                Debug.WriteLine("CLEARING TEXTFIELD");
                info.Text = string.Empty;
                Debug.WriteLine("DONE");
                /*try
                {*/
                    Debug.WriteLine("GETTING DATA STREAM");
                    var str = _socket.InputStream.AsStreamForRead();
                    Debug.WriteLine("DONE");

                    Debug.WriteLine("CREATING VARIABLE");
                    var receivedStrings = "";
                    Debug.WriteLine("DONE");

                    Debug.WriteLine("CREATING STREAMREADER");
                    StreamReader read = new StreamReader(str);
                    Debug.WriteLine("DONE");

                    Debug.WriteLine("READING THE FIRST LINE");
                receivedStrings = read.Read().ToString();
                    Debug.WriteLine("DONE");
                    Debug.WriteLine("!"+receivedStrings+"!");
                    while (receivedStrings != null || receivedStrings != "")
                    {
                        Debug.WriteLine("LOOPING");
                        info.Text += receivedStrings + "\n";
                        Debug.WriteLine("!" + receivedStrings + "!");
                        receivedStrings = read.ReadLine();
                    }
                    Debug.WriteLine("LEFT LOOP");
                    return;
                /*}
                catch (Exception ex)
                {
                    Debug.WriteLine("SOMETHING BROKE:");
                    Debug.WriteLine("\t" + ex.Message + "\n\t" + ex.Source + "\n\t" + ex.StackTrace + "\n\t" + ex.InnerException + "\n\t" + ex.HResult + "\n\t" + ex.HelpLink + "\n\t" + ex.Data);
                    info.Text += ex.Message;
                    info.Text += "\n" + ex.Source + "\n" + ex.StackTrace;
                }*/
            }
            else
            {
                Debug.WriteLine("FAIL");
            }
        }

        private async Task<Boolean> Connect()
        {
            info.Text = "CONNECTING";

            try
            {
                Debug.WriteLine("GETTING DEVICES");
                var devices = await DeviceInformation.FindAllAsync(RfcommDeviceService.GetDeviceSelector(RfcommServiceId.SerialPort));
                Debug.WriteLine("DONE");

                Debug.WriteLine("SELECTING DEVICE");
                var device = devices.Single(x => x.Name == "Dev B");
                Debug.WriteLine("DONE");

                Debug.WriteLine("GETTING DEV FROM ID");
                _service = await RfcommDeviceService.FromIdAsync(device.Id);
                Debug.WriteLine("DONE");

                Debug.WriteLine("CREATING STREAMSOCKET");
                _socket = new StreamSocket();
                Debug.WriteLine("DONE");

                Debug.WriteLine("CONNECTING");
                await _socket.ConnectAsync(_service.ConnectionHostName,_service.ConnectionServiceName,SocketProtectionLevel.BluetoothEncryptionAllowNullAuthentication);
                Debug.WriteLine("DONE");

                Debug.WriteLine("SETTING RESULT TEXT");
                info.Text = "SUCCESS";
                Debug.WriteLine("DONE");
            }
            catch (Exception ex)
            {
                info.Text += ex.Message;
                info.Text += "\n" + ex.Source + "\n" + ex.StackTrace;
                return false;
            }
            return true;
        }


        private void GoToEperimentalPage(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ExperimentalPage));
        }
    }
}