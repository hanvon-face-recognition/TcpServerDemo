/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Splash;

import java.io.IOException;
import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Splash
 */
public class TcpServerDemo extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Locale.setDefault(Locale.CHINESE);// 让Dialogs按钮显示中文
             
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        
         // 设置窗体标题
        stage.setTitle("接收卡点数据"); 
        
        // 设置窗体图标
        stage.getIcons().add(new Image(getClass().getResourceAsStream("FireEyes.png")));
        
        // 设置到屏幕中心
        stage.centerOnScreen();      
        
        // 设置窗口关闭处理函数
        stage.setOnCloseRequest((WindowEvent e) -> {            
            try {
                FXMLDocumentController controller = loader.getController();
                if(controller.TcpServer != null)
                {
                    controller.TcpServer.close();
                    controller.TcpServer = null;
                }
            } 
            catch (IOException ex) {
                // 错误处理
            }
        });
        
        // 显示窗体
        stage.show();       
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
