package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFileChooser;

public class Device {
    private static final String STORAGE_FILE = "devices.txt";
    private static final String STORAGE_OWNER = "owner.txt";
    private final Set<String> signedInDevices;
    private final Set<String> owners;
    
    public static int _ownerId;
    
    public Device() {
        signedInDevices = loadDevicesFromStorage();
        owners = loadOwnerFromStorage() ;
        _ownerId = Integer.parseInt(owners.toArray()[0].toString());
    }
    
    public void signIn(String deviceName,String ownerId) {
        if (signedInDevices.add(deviceName) && owners.add(ownerId)) {
            saveDevicesToStorage();
            saveOwnerToStorage();
            System.out.println("Device " + deviceName + " signed in successfully.");
            System.out.println("Owner  " + ownerId + " save successfully.");
        } else {
            System.out.println("Device " + deviceName + " has already signed in.");
            System.out.println("Owner  " + ownerId + " has already save.");
        }
    }
    
    public void signOut(String deviceName,String ownerId) {
        if (signedInDevices.remove(deviceName) && owners.remove(ownerId)) {
            saveDevicesToStorage();
            saveOwnerToStorage();
            System.out.println("Device " + deviceName + " signed out successfully.");
            System.out.println("Owner  " + ownerId + " signed out successfully.");
        } else {
            System.out.println("Device " + deviceName + " is not signed in.");
            System.out.println("Owner  " + ownerId + " is not signed in.");
        }
    }
    
    public boolean isSignedIn(String deviceName) {
        return signedInDevices.contains(deviceName);
    }
    
    private Set<String> loadDevicesFromStorage() {
        try (BufferedReader reader = new BufferedReader(new FileReader(STORAGE_FILE))) {
            Set<String> devices = new HashSet<>();
            String line;
            while ((line = reader.readLine()) != null) {
                devices.add(line);
            }
            return devices;
        } catch (IOException e) {
            return new HashSet<>();
        }
    }
    
    private Set<String> loadOwnerFromStorage() {
        try (BufferedReader reader = new BufferedReader(new FileReader(STORAGE_OWNER))) {
            Set<String> owners = new HashSet<>();
            String line;
            while ((line = reader.readLine()) != null) {
                owners.add(line);
            }
            return owners;
        } catch (IOException e) {
            return new HashSet<>();
        }
    }
        
    private void saveDevicesToStorage() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STORAGE_FILE))) {
            for (String deviceName : signedInDevices) {
                writer.write(deviceName + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving devices to storage: " + e.getMessage());
        }
    }
    
    private void saveOwnerToStorage() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STORAGE_OWNER))) {
            for (String ownerId : owners) {
                writer.write(ownerId + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving owner to storage: " + e.getMessage());
        }
    }
    
    public static String getDeviceName() {
        try {
            InetAddress localMachine = InetAddress.getLocalHost();
            return localMachine.getHostName();
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException : " + e.getMessage());
        }
        return null;
    }
    
    public static String openImageSelection(){
        String getDir;
        if (System.getProperty("os.name").contains("Windows")){
            getDir = System.getProperty("user.home") + "/OneDrive/Pictures/";
        } else if (System.getProperty("os.name").contains("Mac")){
            getDir = System.getProperty("user.home") + "/Pictures/";
        } else {
            getDir = System.getProperty("user.home");
        }
        
        JFileChooser chooser = new JFileChooser(new File(getDir));
        chooser.setFileFilter(new ImageFileFilter());
        int rv = chooser.showOpenDialog(null);
        if (rv == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
}

class ImageFileFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File f) {
        String fileName = f.getName().toLowerCase();
        return f.isDirectory() || fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png") || fileName.endsWith(".gif") || fileName.endsWith(".bmp");
    }

    @Override
    public String getDescription() {
        return "Image Files (*.jpg, *.jpeg, *.png, *.gif, *.bmp)";
    }
}